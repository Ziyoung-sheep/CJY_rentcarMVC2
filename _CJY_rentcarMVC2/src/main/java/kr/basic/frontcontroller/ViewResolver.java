package kr.basic.frontcontroller;
public class ViewResolver {
   public static String makeView(String nextPage) {
	   return "/WEB-INF/rentcar/"+nextPage+".jsp";
   }
}
