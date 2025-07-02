package interview.vk.recommender_service;

import interview.vk.recommender_service.impl.RecommenderServiceImpl;
import interview.vk.recommender_service.model.Document;
import interview.vk.recommender_service.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class RecommenderServiceTest {

    private static final String MAX_DOCUMENT_SCORE_ID = UUID.randomUUID().toString();
    private static final String MID_DOCUMENT_SCORE_ID = UUID.randomUUID().toString();
    private static final String USER_ID = UUID.randomUUID().toString();

    private static final double MIN_SCORE = 0.0;
    private static final double MID_SCORE = 5.0;
    private static final double MAX_SCORE = 10.0;

    private final User user;

    {
        this.user = new User();
        user.setId(USER_ID);
    }

    @Test
    public void getTopLimit1Test() {
        RecommenderService<Document, User> service = createRecommenderService();

        List<Document> top = service.getTop(user, 1);
        Assert.assertEquals(1, top.size());
        Assert.assertEquals(MAX_DOCUMENT_SCORE_ID, top.get(0).getId());
    }

    @Test
    public void getTopLimit0Test() {
        RecommenderService<Document, User> service = createRecommenderService();

        Assert.assertEquals(0, service.getTop(user, 0).size());
    }

    @Test
    public void getTopLimit10Test() {
        RecommenderService<Document, User> service = createRecommenderService();

        List<Document> top = service.getTop(user, 10);
        Assert.assertEquals(10, top.size());
        Assert.assertEquals(MAX_DOCUMENT_SCORE_ID, top.get(0).getId());
        Assert.assertEquals(MID_DOCUMENT_SCORE_ID, top.get(1).getId());

        for (int i = 2; i < top.size(); i++) {
            Assert.assertEquals('+', top.get(i).getId().charAt(0));
        }
    }


    //todo rbs method to create documents
    private RecommenderService<Document, User> createRecommenderService() {
        Document documentMaxScore = new Document();
        documentMaxScore.setId(MAX_DOCUMENT_SCORE_ID);

        Document documentMidScore = new Document();
        documentMidScore.setId(MID_DOCUMENT_SCORE_ID);

        Scorer<Document, User> scorer = (doc, user) -> {
            if (documentMaxScore.getId().equals(MAX_DOCUMENT_SCORE_ID) && user.getId().equals(USER_ID)) {
                return MAX_SCORE;
            } else if (documentMidScore.getId().equals(MID_DOCUMENT_SCORE_ID) && user.getId().equals(USER_ID)) {
                return MID_SCORE;
            }
            return MIN_SCORE;
        };

        RecommenderServiceImpl service = new RecommenderServiceImpl(scorer);
        service.addDocument(documentMaxScore);
        service.addDocument(documentMidScore);

        IntStream.range(0, 10)
                .forEach(i -> {
                    Document document = new Document();
                    document.setId("+" + UUID.randomUUID());
                    service.addDocument(document);
                });

        return service;
    }

}
