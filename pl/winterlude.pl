canalOpen(saturday).
canalOpen(monday).
canalOpen(tuesday).

raining(saturday).

melting(saturday).
melting(sunday).
melting(monday).

winterlude( X ) :- canalOpen(X), not(raining(X)), not(melting(X)), !.
