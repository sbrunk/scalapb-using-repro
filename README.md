## ScalaPB Scala 3 issue repro with `using` field

Generates invalid code due to `using` being a soft keyword in Scala 3.

Examples for code causing compilation errors:

```scala
def using: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.getUsing)((c_, f_) => c_.copy(using = _root_.scala.Option(f_)))

def withUsing(__v: _root_.scala.Predef.String): RecommendPoints = copy(using = Option(__v))
```

### Usage

This is a normal sbt project. You can compile code with `sbt compile`, run it with `sbt run`, and `sbt console` will start a Scala 3 REPL.

For more information on the sbt-dotty plugin, see the
[scala3-example-project](https://github.com/scala/scala3-example-project/blob/main/README.md).
