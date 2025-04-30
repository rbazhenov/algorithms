package yandex.reviewprepair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * Допустим, мы проводим онлайн-конкурс работ молодых художников. Всего представлено N работ, которые идентифицируются числами от
 * 0 до N−1 включительно. Нужно поддержать 3 типа запроса:
 * Лайк работы с идентификатором id.
 * Дизлайк работы с идентификатором id.
 * Вернуть лучшие K работ. Оценку работы будем считать просто: число лайков минус число дизлайков.
 */
public class _1_PainterWorks {
    private int[] scores;
    private TreeSet<ParticipantStat> orderedWorks;

    private static class ParticipantStat implements Comparable<ParticipantStat> {
        int score;
        int id;

        ParticipantStat(int score, int id) {
            this.score = score;
            this.id = id;
        }

        @Override
        public int compareTo(ParticipantStat other) {
            if (this.score != other.score) {
                return Integer.compare(this.score, other.score);
            }
            return Integer.compare(this.id, other.id);
        }
    }

    public _1_PainterWorks(int participantCount) {
        this.scores = new int[participantCount];
        this.orderedWorks = new TreeSet<>();
        for (int id = 0; id < participantCount; id++) {
            orderedWorks.add(new ParticipantStat(0, id));
        }
    }

    private void changeScore(int participantId, int change) {
        ParticipantStat oldParticipantStat = new ParticipantStat(scores[participantId], participantId);
        orderedWorks.remove(oldParticipantStat);

        scores[participantId] += change;

        ParticipantStat newParticipantStat = new ParticipantStat(scores[participantId], participantId);
        orderedWorks.add(newParticipantStat);
    }

    public void like(int participantId) {
        changeScore(participantId, 1);
    }

    public void dislike(int participantId) {
        changeScore(participantId, -1);
    }

    public ArrayList<Integer> getBestWorks(int count) {
        ArrayList<ParticipantStat> bestWorks = new ArrayList<>(orderedWorks);
        Collections.reverse(bestWorks);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(bestWorks.get(i).id);
        }
        return result;
    }
}
