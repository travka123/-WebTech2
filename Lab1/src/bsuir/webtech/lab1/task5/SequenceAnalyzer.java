package bsuir.webtech.lab1.task5;

class NodeInfo {

    public int sequencesLength;
    public int bestSequenceLength;
    public int nextNodeIndex;

    public NodeInfo(int bestSequencesLength) {
        this.bestSequenceLength = bestSequencesLength;
        sequencesLength = 1;
        nextNodeIndex = -1;
    }

    public NodeInfo(int sequencesLength, int bestSequenceLength, int nextNodeIndex) {
        this.sequencesLength = sequencesLength;
        this.bestSequenceLength = bestSequenceLength;
        this.nextNodeIndex = nextNodeIndex;
    }
}

public class SequenceAnalyzer {
    private interface SequenceCondition {
        boolean check(int a, int b);
    }

    public static boolean[] getLongestAscendingSequence(int[] mas) {
        return getLongestSequence(mas, (a, b) -> a < b);
    }

    private static boolean[] getLongestSequence(int[] mas, SequenceCondition cond) {
        boolean[] longestAscendingSequence = new boolean[mas.length];

        if (mas.length > 0) {

            NodeInfo[] seqInfo = getSequenceInfo(mas, cond);

            int index = 0;
            while (seqInfo[index].bestSequenceLength != seqInfo[index].sequencesLength) {
                index++;
            }

            while (index != -1) {
                longestAscendingSequence[index] = true;
                index = seqInfo[index].nextNodeIndex;
            }

        }
        return longestAscendingSequence;
    }

    private static NodeInfo[] getSequenceInfo(int[] mas, SequenceCondition cond) {
        NodeInfo[] seqInfo = new NodeInfo[mas.length];

        int bestSequenceLength = 1;
        for (int i = seqInfo.length - 1; i >= 0; i--) {

            int nextNodeIndex = -1;
            for (int j = i + 1; j < seqInfo.length; j++) {

                if ((cond.check(mas[i], mas[j])) && ((nextNodeIndex == -1) ||
                        (seqInfo[nextNodeIndex].sequencesLength < seqInfo[j].sequencesLength))) {
                    nextNodeIndex = j;
                }

                if ((nextNodeIndex != -1) &&
                        (seqInfo[nextNodeIndex].sequencesLength >= seqInfo[j].bestSequenceLength)) {
                    break;
                }
            }

            if (nextNodeIndex == -1) {
                seqInfo[i] = new NodeInfo(bestSequenceLength);
            } else {
                bestSequenceLength = Math.max(bestSequenceLength, seqInfo[nextNodeIndex].sequencesLength + 1);
                seqInfo[i] = new NodeInfo(seqInfo[nextNodeIndex].sequencesLength + 1,
                        bestSequenceLength,
                        nextNodeIndex);
            }
        }
        return seqInfo;
    }
}
