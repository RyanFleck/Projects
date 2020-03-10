library ieee;
use ieee.std_logic_1164.all;

-- This program is designed to run on the Altera DE-1
--  Cyclone II EP2C20F484C7 Device. To run on a newer
--  board, replacing the pin assignments file should
--  be sufficient, as newer boards have an equal or
--  greater number of HEX displays, switches, and keys.

entity poc_top is
  port(
    SW : in std_logic_vector(9 downto 0);
	 KEY : in std_logic_vector(3 downto 0);
	 HEX0, HEX1, HEX2, HEX3: out std_logic_vector(6 downto 0);
	 LEDR : out std_logic_vector(9 downto 0);
	 LEDG : out std_logic_vector(7 downto 0)
  );
end poc_top;

architecture structural of poc_top is

	component decoder_2x4b is
	  port(
		 a, b, en : in std_logic;
		 d : out std_logic_vector(3 downto 0)
	  );
	end component;
	
	component encoder_7seg is
	port(
		word_in : in std_logic_vector(3 downto 0);
		hex_out : out std_logic_vector(6 downto 0)
	);
	end component;

begin

	LEDR <= SW;
	
	HEXd3 : encoder_7seg port map(
		word_in => SW(9 downto 6),
		hex_out => HEX3
	);
	
	HEXd2 : encoder_7seg port map(
		word_in => SW(5 downto 2),
		hex_out => HEX2
	);
	
	HEXd1 : encoder_7seg port map(
		word_in => "00" & SW(1 downto 0),
		hex_out => HEX1
	);
	
	HEXd0 : encoder_7seg port map(
		word_in => KEY,
		hex_out => HEX0
	);
	
end structural;