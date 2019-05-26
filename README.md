# tf-gpt-2
Java library for the GPT-2 Text Model using Tensorflow

Basic Usage

Import the Library

```xml
<dependency>
    <groupId>com.simiacryptus</groupId>
    <artifactId>tf-gpt-2</artifactId>
    <version>1.7.1</version>
</dependency>
```

Instantiate the text generator

```java
import com.simiacryptus.text.gpt2.TextGenerator;
import com.simiacryptus.text.gpt2.GPT2Util;
TextGenerator textGenerator = GPT2Util.get345M();
```

Generate text

```java
System.out.println(textGenerator.generateText(500));
```

Generate text given prefix

```java
System.out.println(textGenerator.generateText(500, "Once upon a time"));
```

