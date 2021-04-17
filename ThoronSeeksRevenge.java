/*
                                                          Thoron Seeks Revenge
Devastated by the news about his younger brother Zoron, Thoron; the great water wizard comes -with fire in his eyes- seeking the harshest of revenge.

In his quest of wreaking havoc, he starts by visiting the unlucky city of RiverLine. RiverLine is a nice peaceful city built along a single side of a nice river that flows from left to right. RiverLine residents live in n houses, all lined up along the long, straight river. The houses are numbered 0 to n-1 from left to right. Every house in RiverLine was built and enforced with flood resistance, but some houses were built with more resistance than others.  

Unfortunately, Thoron -the water wizard- is extremely skilled at water magic. He can use his magic to cause the river to flood targeting a specific house hitting this house and every house to the right side of it. If Thoron hits a house, he will hit it with the exact amount of flood force necessary to destroy it. and since the flood continues hitting every house to the right, the flood will also destroy any house on the right that has strictly less resistance than the house that got hit.  

And now, the town is in need of your help. We have records of the flood resistance of every house in the town and for every house in RiverLine, we wish to know its damage count, i.e., the number of houses that would fall if Thoron choose to hit that house.

For example; suppose n = 10 and the resistance of each house in RiverLine from left to right is [20, 47, 71, 23, 48, 1, 94, 7, 99, 75]. In this case, the damage for every house in RiverLine will be [3, 4, 5, 3, 3, 1, 3, 1, 2, 1]

All clear? Then it’s your turn to help.

Given an array containing the resistance of each house in RiverLine, write a O(n log n)-time java method to return the damage for every house in RiverLine
*/

static class House {

    int resistance;
    int indx;

    public House(int resistance, int indx) {
        this.resistance = resistance;
        this.indx = indx;
    }

    public int getIndx() {
        return indx;
    }

    public int getResistance() {
        return resistance;
    }

    @Override
    public String toString() {
        return "" + resistance;
    }

}
public static int[] calculateDamage(int[] arr) {
      House[] houses = new House[arr.length];

    for (int i = 0; i < houses.length; i++) {
        houses[i] = new House(arr[i], i);
    }

    int[] dmg = new int[houses.length];
    Arrays.fill(dmg, 1);

    mergeAndAddDamageRec(houses, 0, houses.length - 1, dmg);

    return dmg;
}

private static void mergeAndAddDamageRec(House[] in, int start, int end, int[] dmg) { // merge in[start..start+inc-1] and in[start+inc..start+2*inc-1]

    if (start >= end) {
        return;
    }

    int mid = (start + end) / 2;
    mergeAndAddDamageRec(in, start, mid, dmg);
    mergeAndAddDamageRec(in, mid + 1, end, dmg);


    int i = 0, j = 0;

    House[] leftside = new House[mid - start + 1];
    System.arraycopy(in, start, leftside, 0, leftside.length);
    House[] rightside = new House[end - mid];
    System.arraycopy(in, mid + 1, rightside, 0, rightside.length);

    while (start <= end) {
        if ((j >= rightside.length) || (i < leftside.length && leftside[i].getResistance() <= rightside[j].getResistance())) {
            dmg[leftside[i].getIndx()] += j;   // this is where the magic happens; 
            in[start++] = leftside[i++];
        } else {
            in[start++] = rightside[j++];
        }
    }

}
