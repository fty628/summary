package com.fty.sort;

public class QuickSort extends SortUtil {

	public static <T extends Comparable<T>> void quicksort(T[] source, boolean ascend) {
		quicksort(source, 0, source.length - 1, ascend);
	}

	/**
	 * <pre>
	 *-----------------------�������򷨣�һ��--------------------------------------------- 
	 *  ��������ܵĿ����������£�������ߵ����趨Ϊ�ᣬ����¼��ֵΪs 
	 *  ������i �����������ҷ��ң�ֱ���ҵ�����s ���� 
	 *  ������j ���������ҷ������ң�ֱ���ҵ�С��s ���� 
	 *  ���i >= j�����뿪��Ȧ 
	 *  ���i < j���򽻻�����i��j������ֵ 
	 *  ������߽��еݻ� 
	 *  �����ұ߽��еݻ�   
	 *--------------------------------------------------------------------------------
	 * </pre>
	 */
	public static <T extends Comparable<T>> void quicksort(T[] source, int fromIndex, int toIndex, boolean ascend) {
		if (fromIndex < toIndex) {
			T s = source[fromIndex]; // ѡ���Ļ�׼ֵ����һ����ֵ��Ϊ��׼ֵ��
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
	 * 	-----------------------�������򷨣�����--------------------------------------------- 
	 *    	��˵������������򷨵ĸ���������ұߵ�ֵs���Ƚϵı�׼�����������з�Ϊ�������ݣ� 
	 *		һ����С��s�Ĳ��ݣ�һ���Ǵ���s�Ĳ��ݣ�һ����δ����Ĳ��ݣ�������ʾ�� 
	 *		    i           j 
	 *		--------|-----------|----------|s 
	 *			С��s     ����s         δ���� 
	 *		������Ĺ����У�i ��j ���᲻�ϵ����ҽ��бȽ��뽻����������л��Ϊ���µ�״̬�� 
	 *		-------------|-----------------|s 
	 *			С��s             ����s 
	 *		Ȼ��s��ֵ�����м䣬������������ͬ�Ĳ�����������ߵ����н�������Ķ�����������ʾ�� 
	 *		-------------|s|--------------- 
	 *			С��s             ����s 
	 *		Ȼ����õݹ�ķ����ظ�����Ĳ��裬�Ϳ���ʵ�������ˡ�
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
