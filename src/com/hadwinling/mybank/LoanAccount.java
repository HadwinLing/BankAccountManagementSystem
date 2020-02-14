package com.hadwinling.mybank;

/**

* 创建时间：2020年2月13日 下午9:08:00

* 项目名称：HadwingLing

* @author HadwinLing

* @version 1.0

* @since JDK 1.6.0_21

* 文件名称：LoanAccount.java

*/
public interface LoanAccount {
	public void requestLoan(double money);
	public void payLoan(double money);
	public double getLoan();

}
