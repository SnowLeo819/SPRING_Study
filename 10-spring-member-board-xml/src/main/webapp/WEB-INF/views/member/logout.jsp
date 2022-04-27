<%@page import="com.TISpjh.util.ScriptWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
	ScriptWriter.alertAndNext(response, "로그아웃되었습니다.", "/member_dao");
%>