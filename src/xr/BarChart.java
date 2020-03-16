package xr;//这是引入包名，根据自己创建的包名可以进行修改

import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import pojo.StudentInfo;
import service.Userservice;
import serviceImpl.UserserviceImpl;

public class BarChart {
	ChartPanel frame1;

	public BarChart() {
		CategoryDataset dataset = getDataSet();// 将获得的数据传递给CategoryDataset类的对象
		JFreeChart chart = ChartFactory.createBarChart3D("统计表", // 图表标题
				"学院", // 目录轴的显示标签
				"疑似人数", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
		);

		CategoryPlot plot = chart.getCategoryPlot();// 获取图表区域对象
		CategoryAxis domainAxis = plot.getDomainAxis(); // 水平底部列表
		domainAxis.setLabelFont(new Font("黑体", Font.BOLD, 12)); // 水平底部标题
		domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12)); // 垂直标题
		ValueAxis rangeAxis = plot.getRangeAxis();// 获取柱状
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 15));// 设置标题字体

		frame1 = new ChartPanel(chart, true); // 这里也可以用chartFrame,可以直接生成一个独立的Frame

	}

	public CategoryDataset getDataSet() {

		String[] college = { "计算机", "历史", "化学", "数统", "生物", "美术", "体育", "文学院", "物电院", "英语" };
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		StudentInfo stu = new StudentInfo();
		Userservice user = new UserserviceImpl();

		for (int i = 0; i <= 9; i++) {
			stu.setCollege(college[i]);
			stu.setInfect("0");
			int count = user.GetStudetnInfoBycollegeAndInfect(stu);
			dataset.addValue(count, college[i], "");// 成绩1
		}
		dataset.addValue(100, "计算机", "");// 成绩1
		dataset.addValue(95, "历史", "");// 成绩2
		dataset.addValue(80, "化学", "");// 成绩3
		dataset.addValue(110, "数统", "");// 成绩4
		return dataset;
	}

	public ChartPanel getChartPanel() {
		return frame1;

	}
/*
	public static void main(String args[]) {
		JFrame frame = new JFrame("成绩表");
		frame.setLayout(new GridLayout(3, 2, 10, 10));
		frame.add(new BarChart().getChartPanel()); // 添加柱形图
		frame.setBounds(0, 0, 900, 800);
		frame.setVisible(true);
	}*/
}
