public class BootstrapTestAnsj {
	public static void main(String[] args) throws Exception {
		Bootstrap.main(new String[]{
				"--zk=192.168.3.137:2181",
				"--host=192.168.3.66",
				"--home=jcoder_home",
				"--port=9095"
		});
	}
}
