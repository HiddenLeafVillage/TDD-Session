package edu.mockitodemo.test.anntations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.params.aggregator.AggregateWith;

import edu.mockitodemo.test.aggregators.PlayerAggregator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@AggregateWith(PlayerAggregator.class)
public @interface JsonToPlayer {

}
