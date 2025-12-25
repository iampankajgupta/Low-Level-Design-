package Practice.CoffeMachine;

import Practice.DecoratorOption;

import java.util.ArrayList;
import java.util.List;

public class DrinkRequest {
    private final DrinkType type;
    // decorators
    /*
    private final boolean extraSugar;
    private final boolean extraMilk;

     */
    private final List<DecoratorOption> decoratorList;

    public List<DecoratorOption> getDecoratorList() {
        return decoratorList;
    }

    public DrinkRequest(Builder builder) {
        this.type = builder.type;
        // to make it immutable
        // this.decoratorList = builder.decoratorList; // this is not immutable
        this.decoratorList = new ArrayList<>(builder.decoratorList); // this is immutable
        /*
            this.extraMilk = builder.extraMilk;
            this.extraSugar = builder.extraSugar;
         */
    }
    public DrinkType getType() {
        return type;
    }

    /*
    public boolean isExtraSugar() {
        return extraSugar;
    }

    public boolean isExtraMilk() {
        return extraMilk;
    }

     */

    public static class Builder {
        private DrinkType type;
        private List<DecoratorOption> decoratorList = new ArrayList<>();
        /*
            private boolean extraSugar;
            private boolean extraMilk;
         */

        public Builder setType(DrinkType type) {
            this.type = type;
            return this;
        }

        public Builder addOptions(DecoratorOption decoratorOption) {
            this.decoratorList.add(decoratorOption);
            return this;
        }
        /*
        public Builder addExtraSugar(boolean extraSugar) {
            this.extraSugar = extraSugar;
            return this;
        }

        public Builder addExtraMilk(boolean extraMilk) {
            this.extraMilk = extraMilk;
            return this;
        }

         */

        public DrinkRequest build() {
            if (type == null) {
                throw new IllegalArgumentException("Drink Type is required");
            }
            return new DrinkRequest(this);
        }
    }
}
