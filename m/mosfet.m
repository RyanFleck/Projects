#!/usr/bin/octave

# Produces some graphs for an Electronics lab.

clc;
close all;
clear;
format long g;
format compact;
grid on;


Vgs = [ 0 : 1 : 8 ];
gm = 0.0001;
Vth = 1;

Id = 0.5 * gm * (Vgs - Vth).*(Vgs - Vth);


figure(1);
plot( Vgs, Id );
title( "b) Vgs vs Id");
xlabel( "Vgs" );
ylabel( "Id" );
grid on;

figure(2);
plot( Vgs, sqrt(Id) );
xlabel( "Vgs" );
ylabel( "Root( Id )" );
title( "c) Vgs vs root( Id )" );
grid on;

gm0 = 0.0005;
gm1 = 0.0006;
gm2 = 0.0007;

Id0 = 0.5 * gm0 * (Vgs - Vth).*(Vgs - Vth);
Id1 = 0.5 * gm1 * (Vgs - Vth).*(Vgs - Vth);
Id2 = 0.5 * gm2 * (Vgs - Vth).*(Vgs - Vth);

figure(3);
plot(Vgs, Id0, Vgs, Id1, Vgs, Id2);
title( "d) Vgs at multiple Gms" );
xlabel( "Vgs" );
ylabel( "Id" );
grid on;

Vds = 1 : 8 ;

Vgs1 = 3;
Vgs2 = 4; 
Vgs3 = 5;

Id3 = gm * ((Vgs1 - Vth ).* Vds - ( .5 * Vds .* Vds));
Id4 = gm * ((Vgs2 - Vth ).* Vds - ( .5 * Vds .* Vds));
Id5 = gm * ((Vgs3 - Vth ).* Vds - ( .5 * Vds .* Vds));

figure(4);
plot(Vds, Id3, Vds, Id4, Vds, Id5);
title( "d) Id at multiple Gate-Source Voltages" );
grid on;
legend('3V','4V','5V');
