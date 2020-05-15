package com.sist.manager;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.MovieDAO;
import com.sist.dao.MovieVO;
/*
 * 				<td class="title">
						<div class="tit5">
							<a href="/movie/bi/mi/basic.nhn?code=35901" title="살인의 추억">살인의 추억</a>
						</div>
					</td>
 * 
 */

public class MovieManager {
	public List<String> movieLinkData(){
		List<String> list = new ArrayList<String>();
		try {
			for(int i=1; i<=40; i++){
				Document doc = Jsoup.connect("https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20200513&page="+i).get();
				Elements links = doc.select("td.title div.tit5 a");
				for(int j=0; j<links.size();j++){
					String strLink = links.get(j).attr("href");
					list.add("https://movie.naver.com"+strLink);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
/*
 * 	private int mno;
	private String title;
	private String poster;
	private String genre;
	private String grade;
	private String director;
	private String actor;
	private int like;
	private String story;
 * 	
 */
	public void movieAllData(){
		try {
			MovieDAO dao = new MovieDAO();
			
			List<String> list=movieLinkData();
			int k=1;
			for(String url:list)
			{
				try {
					/*
					 * <div class="mv_info">
							<h3 class="h_movie">
								
								<a href="./basic.nhn?code=37398">세컨핸드 라이온스</a><
					#####################################################
						<div class="poster">
		
			
				<a href="#" onclick="javascript:common.iwopen('37398');clickcr(this,'ifo.img','','',event);return false;"><img src="https://movie-phinf.pstatic.net/20111222_61/13245057926744K5TV_JPEG/movie_image.jpg?type=m77_110_2"
					 */
					Document doc = Jsoup.connect(url).get();
					Element title = doc.selectFirst("div.mv_info h3.h_movie a");
					Element poster = doc.selectFirst("div.poster a img");
					Element genre = doc.selectFirst("dl.info_spec span a");
					Element grade = doc.select("dl.info_spec dd").get(3);
					
					Element director = doc.selectFirst("div.info_spec2 dl.step1 a");
					Element actor = doc.selectFirst("div.info_spec2 dl.step2 a");
					Element story = doc.selectFirst("div.video div.story_area p.con_tx");
					
					MovieVO vo=new MovieVO();
					vo.setMno(Integer.parseInt(url.substring(url.lastIndexOf("=")+1)));
					System.out.println("========= 영화 정보 =========");
					System.out.println("k="+k);
					System.out.println(title.text());
					System.out.println(poster.attr("src"));
					System.out.println(genre.text());
					System.out.println(grade.text());
					System.out.println(director.text());
					System.out.println(actor.text());
					System.out.println(story.text());
					
					vo.setTitle(title.text());
					vo.setPoster(poster.attr("src"));
					vo.setGenre(genre.text());
					vo.setGrade(grade.text());
					vo.setDirector(director.text());
					vo.setActor(actor.text());
					vo.setStory(story.text());
					dao.movieInsert(vo);
					k++;
				}catch(Exception ex){}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		MovieManager m = new MovieManager();
		m.movieAllData();
	}
}
