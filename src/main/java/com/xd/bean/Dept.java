/**
 * 
 */
package com.xd.bean;

import java.util.List;

/**
 * @company xdkj
 * @author sss专属
 * @data 2019年8月29日下午4:21:03
 * @version 1.8
 */
public class Dept {

	private Integer deptno;
	private String dname;
	private String loc;
	
	private List<Emp> list;
	
	/**
	 * @param deptno
	 * @param dname
	 * @param loc
	 * @param list
	 */
	public Dept(Integer deptno, String dname, String loc, List<Emp> list) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		this.list = list;
	}
	/**
	 * @return the list
	 */
	public List<Emp> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<Emp> list) {
		this.list = list;
	}
	/**
	 * @return the deptno
	 */
	public Integer getDeptno() {
		return deptno;
	}
	/**
	 * @param deptno the deptno to set
	 */
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	/**
	 * @return the dname
	 */
	public String getDname() {
		return dname;
	}
	/**
	 * @param dname the dname to set
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}
	/**
	 * @return the loc
	 */
	public String getLoc() {
		return loc;
	}
	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
	/**
	 * 
	 */
	public Dept() {
		super();
	}
	/**
	 * @param deptno
	 * @param dname
	 * @param loc
	 */
	public Dept(Integer deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", list=" + list + "]";
	}
	
	
}
