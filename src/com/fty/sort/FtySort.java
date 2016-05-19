package com.fty.sort;

public class FtySort {

	public static void exchange(Object[] source, int i, int selected) {
		if (i != selected) {
			Object temp = source[i];
			source[i] = source[selected];
			source[selected] = temp;
		}
	}

	public static <T extends Comparable<T>> boolean compare(T source, T target, boolean ascend) {
		int compare = source.compareTo(target);

		if (compare != 0 && (compare < 0 == ascend)) {
			return true;
		}
		return false;
	}

	/*
	 * 冒泡排序 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
	 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成
	 * 
	 */

	public static <T extends Comparable<T>> void bubble(T[] source, boolean ascend) {
		bubble(source, 0, source.length - 1, ascend);
	}

	/**
	 * 冒泡法排序 比较相邻的元素。如果第一个比第二个大，就交换他们两个
	 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数 针对所有的元素重复以上的步骤，除了最后一个
	 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
	 */
	public static <T extends Comparable<T>> void bubble(T[] source, int fromIndex, int toIndex, boolean ascend) {
		for (int i = fromIndex; i <= toIndex; i++) {
			for (int j = i + 1; j <= toIndex; j++) {
				if (compare(source[i], source[j], !ascend)) {
					exchange(source, i, j);
				}
			}
		}
	}

	public static <T extends Comparable<T>> void quick(T[] source, boolean ascend) {
		quick(source, 0, source.length - 1, ascend);
	}

	/*
	 * 快速排序 快速排序使用分治法策略来把一个序列分为两个子序列
	 * 
	 */
	/**
	 * <pre>
	 *-----------------------快速排序法（一）--------------------------------------------- 
	 * 快速排序  
	 * 从数列中挑出一个元素，称为“基准”
	 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，  
	 * 该基准是它的最后位置。这个称为分割（partition）操作
	 * 递归地把小于基准值元素的子数列和大于基准值元素的子数列排序  
	 *--------------------------------------------------------------------------------
	 * </pre>
	 */
	public static <T extends Comparable<T>> void quick(T[] source, int fromIndex, int toIndex, boolean ascend) {
		if (fromIndex < toIndex) {
			T s = source[fromIndex]; // 选定的基准值（第一个数值作为基准值）
			int i = fromIndex, j = toIndex;
			do {
				while (i < toIndex) {
					if (compare(source[i], s, ascend)) {
						i++;
					} else {
						break;
					}
				}
				while (j > fromIndex) {
					if (compare(source[j], s, !ascend)) {
						j--;
					} else {
						break;
					}
				}
				if (i <= j) {
					exchange(source, i++, j--);
				}
			} while (i <= j);
			quick(source, fromIndex, j, ascend);
			quick(source, i, toIndex, ascend);
		}
	}

	public static <T extends Comparable<T>> void quick2(T[] source, boolean ascend) {
		quick2(source, 0, source.length - 1, ascend);
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
	 * </pre>
	 */
	public static <T extends Comparable<T>> void quick2(T[] source, int fromIndex, int toIndex, boolean ascend) {
		if (fromIndex < toIndex) {
			T s = source[toIndex];
			int i = fromIndex - 1;
			for (int j = fromIndex; j < toIndex; j++) {
				if (compare(source[j], s, ascend)) {
					exchange(source, ++i, j);
				}
			}
			exchange(source, ++i, toIndex);
			quick2(source, fromIndex, i - 1, ascend);
			quick2(source, i + 1, toIndex, ascend);
		}
	}

	/*
	 * 选择排序 选择排序是一种简单直观的排序方法，每次寻找序列中的最小值，然后放在最末尾的位置
	 * 
	 */

	public static <T extends Comparable<T>> void select(T[] source, boolean ascend) {
		select(source, 0, source.length - 1, ascend);
	}

	/**
	 * 选择排序 在未排序序列中找到最小元素，存放到排序序列的起始位置 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾
	 * 以此类推，直到所有元素均排序完毕
	 */
	public static <T extends Comparable<T>> void select(T[] source, int fromIndex, int toIndex, boolean ascend) {
		for (int i = 0; i <= toIndex; i++) {
			int k = i;
			for (int j = k; j <= toIndex; j++) {
				if (compare(source[j], source[k], ascend)) {
					k = j;
				}
			}
			exchange(source, i, k);
		}
	}

	/*
	 * 插入排序 插入排序的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
	 * 
	 */

	public static <T extends Comparable<T>> void insert(T[] source, boolean ascend) {
		insert(source, 0, source.length - 1, ascend);
	}

	/**
	 * 插入排序 从第一个元素开始，该元素可以认为已经被排序 取出下一个元素，在已经排序的元素序列中从后向前扫描
	 * 如果该元素（已排序）大于新元素，将该元素移到下一位置
	 */
	public static <T extends Comparable<T>> void insert(T[] source, int fromIndex, int toIndex, boolean ascend) {
		for (int i = fromIndex + 1; i <= toIndex; i++) {
			T temp = source[i];
			int j = 0;
			for (j = i; j > 0; j--) {
				if (compare(temp, source[j - 1], ascend)) {
					source[j] = source[j - 1];
				} else {
					break;
				}
			}
			source[j] = temp;

			// for (int j = i; j > 0; j--) {
			// if (compare(source[j], source[j - 1], ascend)) {
			// exchange(source, j, j - 1);
			// } else {
			// break;
			// }
			// }
		}
	}

	/*
	 * 希尔排序 算法先将要排序的一组数按某个增量 d（n/2,n为要排序数的个数）分成若 干组，每组中记录的下标相差
	 * d.对每组中全部元素进行直接插入排序，然后再用一个较小 的增量（d/2）对它进行分组，在每组中再进行直接插入排序。当增量减到 1 时，进行直接
	 * 插入排序后，排序完成
	 * 
	 */

	public static <T extends Comparable<T>> void shell(T[] source, boolean ascend) {
		shell(source, 0, source.length - 1, ascend);
	}

	public static <T extends Comparable<T>> void shell(T[] source, int fromIndex, int toIndex, boolean ascend) {
		int d = toIndex, j = 0;
		do {
			d = d / 2;
			for (int x = fromIndex; x <= d; x++) {
				for (int i = x + d; i <= toIndex; i += d) {
					T temp = source[i];
					for (j = i - d; j >= 0; j -= d) {
						if (compare(temp, source[j], ascend)) {
							source[j + d] = source[j];
						} else {
							break;
						}
					}
					source[j + d] = temp;
				}
			}
		} while (d != 1);
	}

}
