package com.sist.dao;
import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmpVO {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int comm;
	private int sal;
	private int deptno;
}
