mother(ann,henry).
mother(ann,mary).
mother(ann,julian).
mother(jane,mark).
mother(jane,francis).
mother(annette,jonathan).
mother(mary,bill).
mother(janice,louise).
mother(lucy,janet).
mother(louise,caroline).
mother(caroline,david).
mother(caroline,janet).

father(henry,jonathan).
father(john,mary).
father(francis,william).
father(francis,louise).
father(john,mark).
father(gavin,lucy).
father(john,francis).

% Experiment of biblical proportions.
father(abraham,isaac).
father(isaac,jacob1).
father(jacob1,judas).
father(judas,phares).
father(phares,esrom).
father(esrom,aram).
father(aram,aminadab).
father(aminadab,nasson).
father(nasson,salmon).
father(salmon,booz).
father(booz,obed).
father(obed,jesse).
father(jesse,david).
father(david,solomon).
father(solomon,roboam).
father(roboam,abia).
father(abia,asa).
father(asa,josaphat).
father(josaphat,joram).
father(joram,ozias).
father(ozias,joatham).
father(joatham,achaz).
father(achaz,ezekias).
father(ezekias,manasses).
father(manasses,amon).
father(amon,josias).
father(josias,jechonias).
father(jechonias,salathiel).
father(salathiel,zorobabel).
father(zorobabel,abiud).
father(abiud,eliakim).
father(eliakim,azor).
father(azor,sadoc).
father(sadoc,achim).
father(achim,eliud).
father(eliud,eleazar).
father(eleazar,matthan).
father(matthan,jacob2).
father(jacob2,joseph).
father(joseph,jesus).

parent(victoria,george).
parent(victoria,edward).

parent(X,Y) :- mother(X,Y).
parent(X,Y) :- father(X,Y).

parent(elizabeth,charles).
parent(elizabeth,andrew).

ancestor(Ancestor,Child) :- parent(Ancestor, Child), !.
ancestor(Ancestor,Child) :- parent(Ancestor, LesserAncestor),
  ancestor(LesserAncestor, Child).

% Test with ancestor(abraham,jesus).


