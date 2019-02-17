## All functional interfaces are annotated with @FunctionalInterface.

## All have ONLY ONE abstract method.
## Lambda = anonymus function.

## FUNCTION

### Function<T, R>

#### abstract method:  R apply(T t);

lambda example (R = String, T = Integer):
Function<Integer, String> integerToString = (Integer i) -> new String("" + i);


### BiFunction<T, U, R>

#### abstract method:  R apply(T t, U u);

lambda example (R = String, T = Integer, U = Person):
BiFunction<Integer, Person, String> getInfo = (Integer i, Person p) -> p.toString() + ": " + i;

### UnaryOperator<T> extends Function<T,T>

#### abstract method:  T apply(T t);

lambda example (T = Integer):
UnaryOperator<Integer> duplicate = (Integer i) -> i * 2;


### BinaryOperator<T> extends BiFunction<T, T, T>

abstract method:  T apply(T t1, T t2);

lambda example (T = Integer):
BinaryOperator<Integer> sum = (Integer i1, Integer i2) -> i1 + i2;


## PREDICATE

### Predicate<T>

#### abstract method:  boolean test(T t);

lambda example (T = Float):
Predicate<Float> isCheeperThan100 = (Float number) -> number < 100;


### BiPredicate<T, U>

#### abstract method:  boolean test(T t, U u);

lambda example (T = Product, U = Float):
BiPredicate<Product, Float> isProductCheeperThan = (Product p, Float price) -> p.getPrice() < price;


## SUPPLIER  AND CONSUMER

### Supplier<T>

#### abstract method: T get();

lambda example (T = Product):

Supplier<Product> productSupplier = () -> new Product(...);


### Consumer<T>

#### abstract method:  void accept(T t);

lambda example (T = Product):

Consumer<Product> priceRaiser = (Product p) -> { p.setPrice(p.getPrice() + 10) };


