%*************************************************************
%*********The ops / notations are defined here****************
%*************************************************************
:-op(500,xfx,ko). 
:-op(490,fx,lagi).
%:-op(300,xfx,kop).
:-op(250,xf,kun).
:-op(300,fy,kop).
:-op(200,xf,ho).


%*************************************************************
%*********************The Knowledge Base**********************
%*************************************************************

rog(poliyoTopa,poliyo).
rog(bcg,chayarog).
rog(dpt,bhagutterog).
rog(dadura,dadura).
rog(tt,dhanustankar).


%*************************************************************
%*********************The Rules World*************************
%*************************************************************


%Rog ko K khop ho. ==> Khop = equivalent khop


go(Question,Answer):-
	Question,
	Answer is (ko(Rog, kop(ho(Kop)))).
ko(Rog,kop(ho(Kop))):-
			rog(Kop,Rog),
			write(ko(Rog, kop(ho(Kop)))), write('.').

ko(Rog,lagi(kop(Kun,liney))):-
			rog(Kun,Rog),
			write(ko(Rog,lagi(Kop(Kun,liney)))), write('.').

%***************************************************************
%*******************The Other Technique*************************
%***************************************************************

% chayarog ko bcg khop ho.
%ko(chayarog,khop(ho(bcg))).
%ko(diptheria,khop(ho(dpt))).
%ko(polio,khop(ho(poliothopa))).
%ko(dadura,khop(ho(dadura))).
%ko(dhanustankar,khop(ho(titi))).

%ko(Rog,kun(ho(Khop))):- 
%		ko(Rog,khop(ho(Khop))).
