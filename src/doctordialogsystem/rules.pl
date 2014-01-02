%*************************************************************
%*********************The Rules World*************************
%*************************************************************


%Example for below rule: polio ko khop K ho? / K ko khop poliothopa ho?
ko(Rog,khop(ho(Khop))):-
			rog(Khop,Rog),
			write(ko(Rog, khop(ho(Khop)))), write('.').

%Example for below rule: polio ko lagi Kun khop liney? / K ko lagi poliothopa khop liney? ?
ko(Rog,lagi(khop(Kun,liney))):-
			rog(Kun,Rog),
			write(ko(Rog,lagi(khop(Kun,liney)))), write('.').




lets talk:-
   write('Expert : Namaskar, Tapai lai k ko barema jankari chaiyeko cha? '),nl,
   write('ka> khop_samanya'),nl,
   write('kha> umer_anushar'),nl,
   read(Jankari),
   problem(Jankari).


 
 reply(bye):-nl,write(' Expert : Goodbye and have a nice day ! '),
                     !.
 


problem(kha):-
                 
                 write('Expert : tapai ko sishu kati umer(mahinama) ko bhayo ?'),nl,
                 read(Umer),nl,
                 agechoice(Umer).	
	


agechoice(Umer):-
	nepaliNumber(Umer,X),
	withInAge(Khop1,X,12),
	write('tapai ley '),write(Khop1),write(' khuwaunubho ?'),nl,
	read(Is),nl,
	is(Is).
        
        

is(yes):-
	write('kati patak?'),nl,
	read(Times),
	nepaliNumber(Times,N),
	write(N).
is(Is):-
        check(Is),
	write('aba khuwaunu hos.'),nl,
        !.
check(yes).

withInAge(Khop1,Min,Max):-
	write(X),nl,
	age(Khop1,X,Max),
	Min>=X.

	
startTalk(SishuAge,Answer,NextItem,Description,NextRule):-
    nepaliNumber(SishuAge,X),
    Answer=X,
    NextItem = 'Rule',
    Description = 'Press ok to continue.',
    NextRule='secondRule'.

secondRule(UserInput,Answer,NextItem,Description,NextRule):-
    nepaliNumber(UserInput,X),
    Answer = X,
    NextItem = 'Question',
    Description = 'tapile aafno sishulai polio ko khop kati choti dinu bhyo?',
    NextRule='arkoKhop'.

arkoKhop(UserInput,Answer,NextItem,Description,NextRule):-
    nepaliNumber(UserInput,X),
    katichotibaki(polio,X, Answer),
    NextItem='Question',
    Description='Tapai ko sishu ko age kati ho?',
    NextRule='startTalk'.

katichotibaki(Rog,UserInput,Answer):-
    times(Rog,Time),
    findDifference(Time,UserInput,Answer).
    
findDifference(Time,UserInput,Answer):-
    Time>UserInput,
    Matra is Time-UserInput,
    nepaliNumber(Abc,Matra),
    join2(Abc,' patak khop khuwauna baki cha',Answer).

findDifference(Time,UserInput,Answer):-
    Time=UserInput,
    Answer = ' khop ko matra pugi sakyo'.

findDifference(Time,UserInput,Answer):-
    Time<UserInput,
    Answer = ' khop ko matra badi bhyo'.



join2(String1,String2,Newstring):-
    name(String1,L1),name(String2,L2),
    append(L1,L2,Newlist),
    name(Newstring,Newlist).


		