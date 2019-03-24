package bazzifer.jobs.com.retrofitctstask.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class APIResponse{

	@SerializedName("employeeList")
	private List<EmployeeListItem> employeeList;

	public void setEmployeeList(List<EmployeeListItem> employeeList){
		this.employeeList = employeeList;
	}

	public List<EmployeeListItem> getEmployeeList(){
		return employeeList;
	}

	@Override
 	public String toString(){
		return 
			"APIResponse{" + 
			"employeeList = '" + employeeList + '\'' + 
			"}";
		}
}