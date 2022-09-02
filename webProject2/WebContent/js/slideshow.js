var slides= document.querySelectorAll("#slides>img");
var prev=document.getElementById("prev");
var next=document.getElementById("next");
var idx=0;

showSlides(idx);

prev.onclick = prevSlide; // 이전 버튼을 클릭하면 prevSlide() 호출
next.onclick = nextSlide; // 이전 버튼을 클릭하면 nextSlide() 호출

function showSlides(index){
	for(let i=0;i<slides.length;i++){
		slides[i].style.display="none"; //모든 이미지를 화면에서 감춘다.
	}
	slides[index].style.display="block"; //n번째 이미지만 화면에 보여준다.
}

function prevSlide(){ //1->0, 2->1, 0->2
	if(idx>0){
		idx-=1;
	}else{
		idx=slides.length-1;
	}
	showSlides(idx);
}

function nextSlide(){ // 0->1, 1->2, 2->0
	if(idx<slides.length-1){
		idx+=1;
	}else{
		idx=0;
	}
	showSlides(idx);
}
