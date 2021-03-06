<%@ page language="java" contentType="text/html; charset=UTF-8"%>
	
<style>

/* The sidebar menu */
.rightArea {
    height: 100%; /* Full-height: remove this if you want "auto" height */
    width: 15%; /* Set the width of the sidebar */
    position: fixed; /* Fixed Sidebar (stay in place on scroll) */
    z-index: 1; /* Stay on top */
    overflow-x: hidden; /* Disable horizontal scroll */
    padding-top: 20px;
    margin-top:10px;
}
	

.floating-menu{
	border-radius:100px;
	z-index:999;
	padding-top:10px;
	padding-bottom:10px;
	left:82%;
	position:fixed;
	top:92%;
	-webkit-transform:translateY(-50%);
	-ms-transform:translateY(-50%);
	transform:translateY(-50%)
}

.main-menu{
	margin:0;
	padding-left:0;
	list-style:none
}

.main-menu li a{
	display:block;
	padding:20px;
	color:#626263;
	border-radius:50px;
	position:relative;
	-webkit-transition:none;
	-o-transition:none;transition:none
}

.main-menu li a:hover{
	background:rgba(244,244,244,.3)
}

.menu-bg{
	position:absolute;
	width:100%;
	height:100%;
	border-radius:50px;
	z-index:-1;
	top:0;
	left:0;
	-webkit-transition:.1s;
	-o-transition:.1s;
	transition:.1s
}

.ripple{
	position:relative;
	overflow:hidden;
	transform:translate3d(0,0,0)
}

.ripple:after{
	content:"";
	display:block;
	position:absolute;
	width:100%;
	height:100%;
	top:0;
	left:0;
	pointer-events:none;
	background-image:radial-gradient(circle,#000 10%,transparent 10.01%);
	background-repeat:no-repeat;
	background-position:50%;
	transform:scale(10,10);
	opacity:0;
	transition:transform .5s,opacity 1s
}.ripple:active:after{transform:scale(0,0);opacity:.2;transition:0s}
	
</style>

<div class="rightArea">
<!-- blog 우측 광고_1 -->
<ins class="adsbygoogle"
     style="display:block"
     data-ad-client="ca-pub-2918447982815807"
     data-ad-slot="5444897677"
     data-ad-format="auto"
     data-full-width-responsive="true">
</ins>
<script>
     (adsbygoogle = window.adsbygoogle || []).push({});
</script>
</div>

<nav class="floating-menu form-inline">
	<ul class="main-menu">
	    <li>
	        <a href="javascript:goTop();" class="ripple">
	            <i class="fa fa-chevron-up fa-lg"></i>
	        </a>
	    </li>
	    <li>
	        <a href="javascript:goBottom();" class="ripple">
	            <i class="fa fa-chevron-down fa-lg"></i>
	        </a>
	    </li>
	</ul>
	<%-- 
	<p class="text-left mt-3 ml-5">
		<b>total</b> <span class="badge badge-pill  badge-dark" id="totalCount"></span><br/>
		<b>today</b> <span class="badge badge-pill badge-dark" id="todayCount"></span>
	</p>
	--%>
</nav>

<script>
$(document).ready(function(){
	//이용안함 google 이용 
	//getJoinCount();
})

goTop = function(){
	$('html, body').scrollTop(0);
}

goBottom = function(){
	$('html, body').scrollTop( $(document).height() );
}

getJoinCount = function(){
	var param = {};
	$.ajax({
		type: "POST",
		url: '/common/getJoinCountList',
		data: JSON.stringify(param),
		contentType: 'application/json',
		success: function(res) {
			$("#totalCount").text(res.joinCountTotalSum+"명");
			$("#todayCount").text(res.joinCountOfToday+"명");
		}
  	});
}

</script>