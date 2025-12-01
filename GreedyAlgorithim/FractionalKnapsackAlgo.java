import java.util.Arrays;

public class FractionalKnapsackAlgo {
   public FractionalKnapsackAlgo() {
   }

   public static double maximumValue(Pair[] var0, int var1, int var2) {
      double var3 = 0.0;

      for(int var5 = 0; var5 < var1 && var2 > 0; ++var5) {
         Pair var6 = var0[var5];
         if (var6.weight <= var2) {
            var3 += (double)var6.value;
            var2 -= var6.weight;
         } else {
            double var7 = (double)var6.value / (double)var6.weight;
            var3 += var7 * (double)var2;
            var2 = 0;
         }
      }

      return var3;
   }

   public static void main(String[] var0) {
      byte var1 = 4;
      int[] var2 = new int[]{100, 60, 100, 200};
      int[] var3 = new int[]{20, 10, 50, 50};
      byte var4 = 90;
      Pair[] var5 = new Pair[var1];

      for(int var6 = 0; var6 < var1; ++var6) {
         var5[var6] = new Pair(var3[var6], var2[var6]);
      }

      Arrays.sort(var5);
      System.out.println(maximumValue(var5, var1, var4));
   }

   static class Pair implements Comparable<Pair> {
      int weight;
      int value;

      public Pair(int var1, int var2) {
         this.weight = var1;
         this.value = var2;
      }

      public int compareTo(Pair var1) {
         return Double.compare((double)var1.value / (double)var1.weight, (double)this.value / (double)this.weight);
      }
   }
}
