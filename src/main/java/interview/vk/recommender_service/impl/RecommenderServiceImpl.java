package interview.vk.recommender_service.impl;

import interview.vk.recommender_service.RecommenderService;
import interview.vk.recommender_service.Scorer;
import interview.vk.recommender_service.model.Document;
import interview.vk.recommender_service.model.User;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;


public class RecommenderServiceImpl implements RecommenderService<Document, User> {

    //    private final Map<User, List<Document>> map;
    private final List<Document> documents;

    private final Scorer<Document, User> scorer;

    public RecommenderServiceImpl(Scorer<Document, User> scorer) {
        this.scorer = scorer;
        this.documents = new CopyOnWriteArrayList<>();
    }

    @Override
    public List<Document> getTop(User user, int limit) {
        //дорого сортировать топ
        //сохранять результат

        //O(nLogN)
        return documents.stream()
                .sorted(Comparator.comparing(document -> scorer.getScore((Document) document, user)).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public void addDocument(Document document) {
        //O(1)
        documents.add(document);
        //сортировать здесь
    }
}
