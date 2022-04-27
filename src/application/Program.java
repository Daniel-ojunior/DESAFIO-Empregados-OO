package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();
		
		
		Address address = new Address(email, phone);
		Department department = new Department(departmentName, payDay, address);
		
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		
		
		for(int i = 1 ; i <=n ; i++) {
			
			sc.nextLine();
			System.out.println("Dados do funcionário " + i + ":");
			System.out.print("Nome: ");
			String employeeName = sc.nextLine();
			System.out.print("Salário: ");
			double employeeSal = sc.nextDouble();
			
			Employee employee = new Employee(employeeName, employeeSal);
			department.addEmployee(employee);
			
		}
		
		System.out.println();
		showReport(department);
		
		sc.close();

	}
	
	private static void showReport(Department dept) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("FOLHA DE PAGAMENTO: \n");
		sb.append("Departamento " + dept.getName() + " = R$ " );
		sb.append(String.format("%.2f", dept.payroll()) + "\n");
		sb.append("Pagamento realizado no dia " + dept.getPayDay() + "\n");
		sb.append("Funcionários: \n");
		
		for(int i = 0 ; i < dept.getEmployees().size(); i++) {
			
			sb.append(dept.getEmployees().get(i).getName() + "\n" );
		}
		
		sb.append("Para dúvidas favor entrar em contato: ");
		sb.append(dept.getAddress().getEmail());
		
		System.out.println(sb.toString());

	}

}
