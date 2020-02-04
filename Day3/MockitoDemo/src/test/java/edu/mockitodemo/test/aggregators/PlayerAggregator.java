package edu.mockitodemo.test.aggregators;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import com.google.gson.Gson;

import edu.mockitodemo.model.Player;

public class PlayerAggregator implements ArgumentsAggregator {

	@Override
	public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context)
			throws ArgumentsAggregationException {
		String json = accessor.get(0).toString();
		return new Gson().fromJson(json, Player.class);
	}

}
