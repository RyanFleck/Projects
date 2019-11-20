class EnvVarTest{
    public static void main(String[] args){
        System.out.println("Hello, World!");
        // System.getenv works fine on Debian 10.
        System.out.println(System.getenv("OWM_KEY"));
    }
}
