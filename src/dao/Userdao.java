package dao;

import java.util.List;

import pojo.StudentInfo;

public interface Userdao {

		//��ѯѧ����ȫ����Ϣ
		public List<StudentInfo> getStudetnInfo();
		//����Ա��ѯ��ѧԺ��ѧ����Ϣ
		public List<StudentInfo> getStudetnInfoBycollege(StudentInfo stu);
		
		//��ѯ�ض���ѧԺ��ѧ���ĸ�Ⱦ��Ϣ
		public int GetStudetnInfoBycollegeAndInfect(StudentInfo stu);
}
