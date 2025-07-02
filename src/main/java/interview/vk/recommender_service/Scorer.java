package interview.vk.recommender_service;

/**
 * Величина релавантоности документа к пользователю.
 */
public interface Scorer <Document, User> {

    double getScore(Document doc, User user);
}
