module Main where

import Lib

x = 3 `mod` 2

main :: IO ()
main = do
    someFunc
    print (x == 1)

-- to run, go to terminal and type "stack run"
