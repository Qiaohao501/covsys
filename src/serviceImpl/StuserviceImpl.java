package serviceImpl;

import dao.Studao;
import daoImpl.StudaoImpl;
import pojo.StudentInfo;

public class StuserviceImpl implements service.Stuservice {

	private Studao studao;
	//�û�new service����ʱ��new studao��������һ������new service����
	public StuserviceImpl() {
		studao =  new StudaoImpl();
	}
	
	public void AddStu(StudentInfo stu) {

		studao.addstu(stu);
	}
}
