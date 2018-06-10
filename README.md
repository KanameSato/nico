# nico
Scalaで、顔文字を用いてプログラミングができるようになります(ネタです)。  
例えば、`Hello World!!`と出力するプログラムを以下のように書くことができます。
```Main.scala
import nico._
import nico.Nico._

object Main extends App {
  (start
    ^c^o^o^o^o^o^o^o^o^o^p^e^o^o^o^o^o^o^o^o^c^u^q^e^v^c^o^o^o^o^o^o^ endline
    ^o^p^e^o^o^o^o^c^u^q^e^o^v^o^o^o^o^o^o^o^v^v^o^o^o^v^p^u^q^c^o^o^ endline
    ^o^o^o^o^o^o^p^e^o^o^o^o^c^u^q^e^v^c^o^o^o^o^o^o^o^o^o^o^o^p^e^o^ endline
    ^o^o^o^o^c^u^q^e^v^c^o^o^o^o^o^o^o^o^p^e^o^o^o^c^u^q^e^v^o^o^o^v^ endline
    ^u^u^u^u^u^u^v^u^u^u^u^u^u^u^u^v^p^u^q^c^o^o^o^o^o^o^o^o^p^e^o^o^ endline
    ^o^o^c^u^q^e^o^v^p^u^q^o^o^o^o^o^o^o^o^o^o^v^
  end).execute
}
```

記述法は`BrainF*ck`に従います。  
対応表は以下の通りです。  

| BrainF\*ck | nico |
|:-:|:-:|
| + |^o^|
| - |^u^|
| > |^c^|
| < |^e^|
| . |^v^|
| , |^a^|
| \[ |^p^|
| \] |^q^|

`end`と`endline`は全く同じ働きをしますが、その意味の通りに使うことを推奨します。  

## コンパイルに失敗する場合
Scalaでは、ステートメントが長すぎる場合、コンパイルフェーズで`StackOverFlow`を起こす可能性があります。  
どうしてもコンパイルしたい場合は`export SBT_OPTS="-Xss4M"`で割り当てメモリを増やした上で`sbt`を起動してください。
