package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{
//rename 하기위해서는 FileRenamePolicy를 인터페이스로 가져와야함
//rename()=기존의 파일을 전달받아서 파일명 수정작업을 마친 후에 수정된 파일을 반환해주는 메소드
	@Override
	public File rename(File originFile) {
		//원본 파일명
		String originName = originFile.getName();
		
		//수정 파일명 : 파일 업로드 시간(년월일분초) + 5자리 랜덤값(10000~99999)=> 최대한 이름이 겹치지 않게끔작성
		//확장자 : 원본 파일 그대로
		
		//파일업로드 시간 구하기() currentTime
		
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		int ranNum = (int)(Math.random()*90000 + 10000);
		
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime+ranNum+ext;
		//원본파일 확장자 text
		//확장자 같은경우는 .~~~로 작성되어있고 만약 파일명 중간에 . 기호가 있을 수 있으니 마지막 . 기호 기준으로 잡아준다.
		
		//원본파일을 수정된 파일며응로 적용시켜 파일 객체 변환
		
		return new File(originFile.getParent(),changeName);
	}
	

}