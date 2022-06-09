package com.llk.laborsystem.utils.pager;

import java.util.List;
/**
 * <b> 分页通用类 </b>
 * @param <T>
 *
 */
public class Pager<T> {

	//要结果数据
	//要每页条数
	//要当前页数
	//总共条数（符合条件的总共条数）
	//符合条件的总页数
	private List<T> list;  //数据
	private int pageSize;  //每页条数
	private int currentPage;  //当前页
	private long total;  //总条数
	private long totalPage; //总页数
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
		// 总页数
		this.totalPage = this.total % this.pageSize > 0 ? this.total / this.pageSize + 1
		 				: this.total / this.pageSize;
	}
	public long getTotalPage() {
		return totalPage;
	}
	@Override
	public String toString() {
		return "Pager1 [list=" + list + ", pageSize=" + pageSize + ", currentPage=" + currentPage + ", total=" + total
				+ ", totalPage=" + totalPage + "]";
	}

}
