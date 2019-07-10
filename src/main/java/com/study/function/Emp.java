package main.java.com.study.function;

import java.util.Objects;

/**
 * @author: whb
 * @date: 2019/7/10 16:13
 * @description: Emp对象
 */
public class Emp {
    private int empno;
    private String ename;

    public static void printEmp(Emp emp) {
        System.out.println("empno：" + emp.getEmpno() + "；ename：" + emp.getEname());
    }

    public Emp(int empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Emp)) {
            return false;
        }
        Emp emp = (Emp) o;
        return getEmpno() == emp.getEmpno() &&
                Objects.equals(getEname(), emp.getEname());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmpno(), getEname());
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                '}';
    }
}
