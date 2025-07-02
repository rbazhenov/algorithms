/**
 * Нам дана функция которая оценивает релевантность документа пользователю
 * <p>
 * interface Scorer<Document, User> {
 * double getScore(Document doc, User user);
 * }
 * <p>
 * Необходимо реализовать сервис который может сохранять документ и получать  топ К (limit) документов для пользователя по скору этой функции
 * <p>
 * interface RecommenderService<Document, User> {
 * List<Document> getTop(User user, int limit);
 * <p>
 * void addDocument(Document document);
 * }
 */
package interview.vk.recommender_service;