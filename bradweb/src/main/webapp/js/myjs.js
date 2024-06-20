window.onload =function(){
	
	//接收前端資料
	let start = document.getElementById("start");
	let mesgDiv = document.getElementById("mesgDiv");
	let mesg = document.getElementById("mesg");
	let send = document.getElementById("send");
	let log = document.getElementById("log");
	
	//開始做webSocket
	let webSocket;
	
	//前端strt按鈕按下 addEvenListener(什麼事件 ,碰到事件觸發方法)
	start.addEventListener("click", function(){
		connect();
	});
	
	//前端send(訊息去)按鈕按下 addEvenListener(什麼事件 ,碰到事件觸發方法)
	send.addEventListener("click",function(){
		//幫我傳送訊息出去
		//webSocket.send("haha");
		
		//改成json傳送
		let message = {
			message: mesg.value
		};
		webSocket.send(JSON.stringify(message));
		
	});
		
	
	//設定初始看得到strt
	start.style.display = "block";
	//設定初始看不到send
	mesgDiv.style.display = "none";
	//連線只做一次
	function connect(){
		//建出webSocket （帶字串 ws=通訊協定 / 伺服器 /名稱 ） 
		//現在是只能提供給本機操作如果要給大家做連線要修改這裡
		webSocket = new WebSocket("ws://localhost:8080/bradweb/myserver");
		//再webSocket除錯的時候要做什麼
		webSocket.onerror = function(){
			console.log("ERROR");
			start.style.display = "block";
			mesgDiv.style.display = "none";
		};
		//再webSocket開啟的時候要做什麼
		webSocket.onopen = function(){
			console.log("OPEN");
			start.style.display = "none";
			mesgDiv.style.display = "block";			
		};
		//再webSocket關閉的時候要做什麼
		webSocket.onclose = function(){
			console.log("CLOSE");
			start.style.display = "block";
			mesgDiv.style.display = "none";
			
		};
		//再webSocket傳送訊息的時候要做什麼
		webSocket.onmessage = function(event){
			
			console.log(event);
			//建立訊息的物件 （參數 ,資料來自哪裡）
			let mesgObj = JSON.parse(event.data);
			//將收到的資料寫到網頁上
			log.innerHTML += mesgObj.message + "<br />";
			
		};
	}
			
}