library ieee;
use ieee.std_logic_1164.all;

entity decoder_2x4b is
  port(
    a, b, en : in std_logic;
    d : out std_logic_vector(3 downto 0)
  );
end decoder_2x4b;

architecture structural of decoder_2x4b is
begin
  d <= "0000" when (en='0') else
       "0001" when (a='0' and b='0') else
       "0010" when (a='0' and b='1') else
       "0100" when (a='1' and b='0') else
       "1000" when (a='1' and b='1');
end structural;