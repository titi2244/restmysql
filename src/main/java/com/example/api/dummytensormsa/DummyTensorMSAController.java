package com.example.api.dummytensormsa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.NeuralNetwork;

@RestController
@RequestMapping("api/tensorMSA")
public class DummyTensorMSAController {

	@RequestMapping(value = "getAllANNList", method = RequestMethod.POST)
	List<NeuralNetwork> getAllANNList() {
		List<NeuralNetwork> list = new ArrayList<NeuralNetwork>();
		list.add(new NeuralNetwork("NN1", "MES", "Pilot1", "MES Pilot TestModel1",
				"This AMD is Testing Model_1 for develop MES Pilot", "Y", "autoencoding",
				"I don't know what it means"));
		list.add(new NeuralNetwork("NN2", "MES", "Pilot2", "MES Pilot TestModel2",
				"This AMD is Testing Model_2 for develop MES Pilot", "Y", "autoencoding",
				"I don't know what it means"));
		list.add(new NeuralNetwork("NN3", "MES", "Pilot3", "MES Pilot TestModel3",
				"This AMD is Testing Model_3 for develop MES Pilot", "Y", "autoencoding",
				"I don't know what it means"));
		return list;
	}

	@RequestMapping(value = "getAllANNList_GET", method = RequestMethod.GET)
	List<NeuralNetwork> getAllANNList_GET() {
		List<NeuralNetwork> list = new ArrayList<NeuralNetwork>();
		list.add(new NeuralNetwork("NN1", "MES", "Pilot1", "MES Pilot TestModel1",
				"This AMD is Testing Model_1 for develop MES Pilot", "Y", "autoencoding",
				"I don't know what it means"));
		list.add(new NeuralNetwork("NN2", "MES", "Pilot2", "MES Pilot TestModel2",
				"This AMD is Testing Model_2 for develop MES Pilot", "Y", "autoencoding",
				"I don't know what it means"));
		list.add(new NeuralNetwork("NN3", "MES", "Pilot3", "MES Pilot TestModel3",
				"This AMD is Testing Model_3 for develop MES Pilot", "Y", "autoencoding",
				"I don't know what it means"));
		return list;
	}
	
	@RequestMapping(value = "getNeuralNetwork_GET", method = RequestMethod.GET)
	NeuralNetwork getNeuralNetwork_GET() {
		return (new NeuralNetwork("NN1", "MES", "Pilot1", "MES Pilot TestModel1",
				"This AMD is Testing Model_1 for develop MES Pilot", "Y", "autoencoding",
				"I don't know what it means"));
		
	}
}
