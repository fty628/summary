package com.fty.sort;

public class QuickSort extends SortUtil {

	public static <T extends Comparable<T>> void quicksort(T[] source, boolean ascend) {
		quicksort(source, 0, source.length - 1, ascend);
	}

	/**
	 * <pre>
	 *-----------------------快速排序法（一）--------------------------------------------- 
	 *  这边所介绍的快速演算如下：将最左边的数设定为轴，并记录其值为s 
	 *  令索引i 从数列左方往右方找，直到找到大于s 的数 
	 *  令索引j 从数列左右方往左方找，直到找到小于s 的数 
	 *  如果i >= j，则离开回圈 
	 *  如果i < j，则交换索引i与j两处的值 
	 *  对轴左边进行递回 
	 *  对轴右边进行递回   
	 *--------------------------------------------------------------------------------
	 * </pre>
	 */
	public static <T extends Comparable<T>> void quicksort(T[] source, int fromIndex, int toIndex, boolean ascend) {
		if (fromIndex < toIndex) {
			T s = source[fromIndex]; // 选定的基准值（第一个数值作为基准值）
			int i = fromIndex, j = toIndex;
			do {
				while (i < toIndex) {
					if(compare(source[i], s, ascend)){
						i++;
					}else{ break; }
				}
				while (j > fromIndex) {
					if(compare(source[j], s, !ascend)){
						j--;
					}else{ break; }
				}
				if(i <= j){
					exchange(source, i++, j--);
				}
			} while (i <= j);
			quicksort(source, fromIndex, j, ascend);
			quicksort(source, i, toIndex, ascend);
		}
	}

	public static <T extends Comparable<T>> void quicksort3(T[] source, boolean ascend) {
		quicksort2(source, 0, source.length - 1, ascend);
	}
	/**
	 * <pre>
	 * 	-----------------------快速排序法（二）--------------------------------------------- 
	 *    	先说明这个快速排序法的概念，它以最右边的值s作比较的标准，将整个数列分为三个部份， 
	 *		一个是小于s的部份，一个是大于s的部份，一个是未处理的部份，如下所示： 
	 *		    i           j 
	 *		--------|-----------|----------|s 
	 *			小于s     大于s         未处理 
	 *		在排序的过程中，i 与j 都会不断的往右进行比较与交换，最后数列会变为以下的状态： 
	 *		-------------|-----------------|s 
	 *			小于s             大于s 
	 *		然后将s的值置于中间，接下来就以相同的步骤会左右两边的数列进行排序的动作，如下所示： 
	 *		-------------|s|--------------- 
	 *			小于s             大于s 
	 *		然后采用递归的方法重复上面的步骤，就可以实现排序了。
	 *  --------------------------------------------------------------------------------
	 *</pre>
	*/
	public static <T extends Comparable<T>> void quicksort2(T[] source, int fromIndex, int toIndex, boolean ascend) {
		if (fromIndex < toIndex) {
			T s = source[toIndex];
			int i = fromIndex - 1;
			for (int j = fromIndex; j < toIndex; j++) {
				if (compare(source[j], s, ascend)) {
					exchange(source, ++i, j);
				}
			}
			exchange(source, ++i, toIndex);
			quicksort2(source, fromIndex, i - 1, ascend);
			quicksort2(source, i + 1, toIndex, ascend);
		}
	}

}
