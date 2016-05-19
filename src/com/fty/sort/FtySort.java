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
	 * ð������ ð��������һ�ּ򵥵������㷨�����ظ����߷ù�Ҫ��������У�һ�αȽ�����Ԫ�أ�������ǵ�˳�����Ͱ����ǽ���������
	 * �߷����еĹ������ظ��ؽ���ֱ��û������Ҫ������Ҳ����˵�������Ѿ��������
	 * 
	 */

	public static <T extends Comparable<T>> void bubble(T[] source, boolean ascend) {
		bubble(source, 0, source.length - 1, ascend);
	}

	/**
	 * ð�ݷ����� �Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�����������
	 * ��ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԡ�����һ�㣬����Ԫ��Ӧ�û��������� ������е�Ԫ���ظ����ϵĲ��裬�������һ��
	 * ����ÿ�ζ�Խ��Խ�ٵ�Ԫ���ظ�����Ĳ��裬ֱ��û���κ�һ��������Ҫ�Ƚ�
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
	 * �������� ��������ʹ�÷��η���������һ�����з�Ϊ����������
	 * 
	 */
	/**
	 * <pre>
	 *-----------------------�������򷨣�һ��--------------------------------------------- 
	 * ��������  
	 * ������������һ��Ԫ�أ���Ϊ����׼��
	 * �����������У�����Ԫ�رȻ�׼ֵС�İڷ��ڻ�׼ǰ�棬����Ԫ�رȻ�׼ֵ��İ��ڻ�׼�ĺ��棨��ͬ�������Ե���һ�ߣ���������ָ�֮��  
	 * �û�׼���������λ�á������Ϊ�ָpartition������
	 * �ݹ�ذ�С�ڻ�׼ֵԪ�ص������кʹ��ڻ�׼ֵԪ�ص�����������  
	 *--------------------------------------------------------------------------------
	 * </pre>
	 */
	public static <T extends Comparable<T>> void quick(T[] source, int fromIndex, int toIndex, boolean ascend) {
		if (fromIndex < toIndex) {
			T s = source[fromIndex]; // ѡ���Ļ�׼ֵ����һ����ֵ��Ϊ��׼ֵ��
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
	 * ѡ������ ѡ��������һ�ּ�ֱ�۵����򷽷���ÿ��Ѱ�������е���Сֵ��Ȼ�������ĩβ��λ��
	 * 
	 */

	public static <T extends Comparable<T>> void select(T[] source, boolean ascend) {
		select(source, 0, source.length - 1, ascend);
	}

	/**
	 * ѡ������ ��δ�����������ҵ���СԪ�أ���ŵ��������е���ʼλ�� �ٴ�ʣ��δ����Ԫ���м���Ѱ����СԪ�أ�Ȼ��ŵ���������ĩβ
	 * �Դ����ƣ�ֱ������Ԫ�ؾ��������
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
	 * �������� ��������Ĺ���ԭ����ͨ�������������У�����δ�������ݣ��������������дӺ���ǰɨ�裬�ҵ���Ӧλ�ò�����
	 * 
	 */

	public static <T extends Comparable<T>> void insert(T[] source, boolean ascend) {
		insert(source, 0, source.length - 1, ascend);
	}

	/**
	 * �������� �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ������� ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ��
	 * �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ��
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
	 * ϣ������ �㷨�Ƚ�Ҫ�����һ������ĳ������ d��n/2,nΪҪ�������ĸ������ֳ��� ���飬ÿ���м�¼���±����
	 * d.��ÿ����ȫ��Ԫ�ؽ���ֱ�Ӳ�������Ȼ������һ����С ��������d/2���������з��飬��ÿ�����ٽ���ֱ�Ӳ������򡣵��������� 1 ʱ������ֱ��
	 * ����������������
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
