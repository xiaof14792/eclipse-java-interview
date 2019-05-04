import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) {
//		testGenericType();
		
		testGsonBuilder();
	}

	private static void testGsonBuilder() {
		//ͨ��GsonBuilder�����ã�����֧�ֵ���NULLֵ��������NULLֵ��
		Gson gson = new GsonBuilder().serializeNulls().create();
		User user = new User();
		user.name = "����";
		user.age = 26;
		String gString = gson.toJson(user);
		System.out.println(gString);
		
		User user2 = gson.fromJson(gString, User.class);
		System.out.println(user2.email);
		
	}

	private static void testGenericType() {
		List list = new ArrayList();
		list.add(123);
		list.add(1.23);
		list.add('c');
		list.add("abc");
		System.out.println(list.size());
	}

}
