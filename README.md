# tf-gpt-2
Java library for the GPT-2 Text Model using Tensorflow

Basic Usage

Import the Library

```xml
&lt;dependency&gt;
    &lt;groupId&gt;com.simiacryptus&lt;/groupId&gt;
    &lt;artifactId&gt;tf-gpt-2&lt;/artifactId&gt;
    &lt;version&gt;1.7.1&lt;/version&gt;
&lt;/dependency&gt;
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

