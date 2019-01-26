package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.Computation.Computation;
import ca.vapurrmaid.discretemathapplications.domain.Computation.ComputationalResult;
import ca.vapurrmaid.discretemathapplications.domain.Computation.ComputationalStep;
import ca.vapurrmaid.discretemathapplications.domain.MathTopic.SubTopic;
import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;
import ca.vapurrmaid.discretemathapplications.repository.SubTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vapurrmaid
 */
@Service
public class DivisibilityServiceImpl implements DivisibilityService {

    private final SubTopic subTopic;

    @Autowired
    public DivisibilityServiceImpl(final SubTopicRepository subTopicRepository) {
        subTopic = subTopicRepository.findByName("divisibility").get();
    }

    @Override
    public Computation isNumberDivisibleByTwo(NaturalNumber n) {
        Computation computation = new Computation(subTopic);
        int lastBit = n.getNumberAsInteger() & 1;
        computation.appendComputationalStep(new ComputationalStep("obtain last digit", String.format("least significant bit of %d = %s", n.getNumberAsInteger(), lastBit)));
        if (lastBit == 1) {
            computation.appendComputationalStep(new ComputationalStep("test last digit multiple of 2", "least signification bit = 1 => false"));
            computation.setResult(new ComputationalResult(false));
        } else {
            computation.appendComputationalStep(new ComputationalStep("test last digit multiple of 2", "least significant bit = 0 => true"));
            computation.setResult(new ComputationalResult(true, String.format("therefore 2|%s", n.getNumberAsInteger())));
        }
        return computation;
    }

    @Override
    public Computation isNumberDivisibleByThree(NaturalNumber n) {
        Computation computation = new Computation(subTopic);

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByFour(NaturalNumber n) {
        Computation computation = new Computation(subTopic);

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByFive(NaturalNumber n) {
        Computation computation = new Computation(subTopic);

        return computation;
    }

    @Override
    public Computation isNumberDivisibleBySix(NaturalNumber n) {
        Computation computation = new Computation(subTopic);

        return computation;
    }

    @Override
    public Computation isNumberDivisibleBySeven(NaturalNumber n) {
        Computation computation = new Computation(subTopic);

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByEight(NaturalNumber n) {
        Computation computation = new Computation(subTopic);

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByNine(NaturalNumber n) {
        Computation computation = new Computation(subTopic);

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByTen(NaturalNumber n) {
        Computation computation = new Computation(subTopic);

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByEleven(NaturalNumber n) {
        Computation computation = new Computation(subTopic);

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByTwelve(NaturalNumber n) {
        Computation computation = new Computation(subTopic);

        return computation;
    }

}
