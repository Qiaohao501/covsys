package service;

import java.util.List;

import pojo.StudentInfo;

public interface Userservice {

	//��ѯ���е�ѧ����Ϣ
	public List<StudentInfo> GetStudetnInfo();
	
	//��ѯ�ض���ѧԺ��ѧ����Ϣ
	public List<StudentInfo> GetStudetnInfoBycollege(StudentInfo stu);
	
	//��ѯ�ض���ѧԺ��ѧ���ĸ�Ⱦ��Ϣ
	public int GetStudetnInfoBycollegeAndInfect(StudentInfo stu);
}
