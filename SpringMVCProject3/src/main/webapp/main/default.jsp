<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.0/react.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.0/react-dom.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> 
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div id="root"></div>
	<script type="text/babel">
	class MainMovieList extends React.Component
	{
		constructor(props)
		{
			super(props);
			this.state={
				movie:[],
				no:1
			}
		}
		componentWillMount()
		{
			axios.get("http://localhost:8081/myapp2/main/def.do",{
					params:{
						no:this.state.no
					}
				}).then((res)=>{
				this.setState({movie:res.data})
				console.log(res);
			});
		}
		movieClick(no){
			this.state.no=no;
			axios.get("http://localhost:8081/myapp2/main/def.do",{
					params:{
						no:this.state.no
					}
				}).then((res)=>{
				this.setState({movie:res.data})
				console.log(res);
			});

		}

		render()
		{
			const html=this.state.movie.map((m)=>
				<tr>
					<td className="text-center">
						<img src={"http://www.kobis.or.kr"+m.thumbUrl} width="35" height="35"/>
					</td>
					<td className="text-center">{m.movieNm}</td>
					<td className="text-center">{m.genre}</td>
					<td className="text-center">{m.watchGradeNm}</td>
				</tr>
			)
			return(
				<div>
					<button className="btn btn-sm btn-primary" onClick={this.movieClick.bind(this,1)}>일일 박스 오피스</button>
					<button className="btn btn-sm btn-danger" onClick={this.movieClick.bind(this,2)}>실시간 예매율</button>
					<button className="btn btn-sm btn-success" onClick={this.movieClick.bind(this,3)}>좌석점유율순위</button>
					<button className="btn btn-sm btn-info" onClick={this.movieClick.bind(this,4)}>온라인상영관 일일</button>
				<div className="row">
					<div className="col-sm-6">
					</div>
					<div className="col-sm-6">
					<table className="table table-hover">
					<thead>
						<tr>
						<th className="text-center"></th>
						<th className="text-center">영화명</th>
						<th className="text-center">장르</th>
						<th className="text-center">등급</th>
						</tr>
					</thead>
						<tbody>
							{html}
						</tbody>
					</table>		
				</div>
				</div>
				</div>				
			);
		}
	}
		ReactDOM.render(<MainMovieList />, document.getElementById('root'))
	</script>
</body>
</html>