package com.justai.jaicf.template.scenario

import com.justai.jaicf.channel.googleactions.actions
import com.justai.jaicf.channel.googleactions.dialogflow.DialogflowIntent
import com.justai.jaicf.model.scenario.Scenario

object MainScenario: Scenario() {

    init {
        state("main") {
            activators {
                intent("Start")
            }

            action {
                reactions.run {
                    say("Make yourself comfortable! Will you taste red or white wine?")
                    image("https://drive.google.com/uc?export=view&id=1DNJiC0pvnTCnaMR_OM1_5Vn0chROqKh9")
                    buttons("Red", "White")
                }
            }

            state("RedWine", modal = true) {
                activators {
                    intent("RedWine")
                }

                action {
                    reactions.actions?.run {
                        addSimpleResponse("Serve red wines slightly cooler than room temperature.\n\nAre you ready?","Serving temperature greatly affects what flavors and aromas of the wine you'll smell. Serve red wines slightly cooler than room temperature. If the wine doesn't have any flavor, try warming it up. Are you ready?")
                        image("https://drive.google.com/uc?export=view&id=1HcXs1ZR3p2iQ1W_2sLWYVbEdqTOJh1Gk")
                        buttons("Yes", "No")
                    }
                }

                state("Look", modal = true) {
                    activators {
                        intent("Ready")
                    }

                    action {
                        reactions.actions?.run {
                            addSimpleResponse(
                                "Is the color maroon, purple, ruby, garnet, red, brick or even brownish?",
                                "Check out the Color and Clarity. Pour a glass of wine into a suitable wine glass. Then take a good look at the wine. Tilt the glass away from you and check out the color of the wine from the rim edges to the middle of the glass (it's helpful to have a white background—either paper, napkin or a white tablecloth). Is the color maroon, purple, ruby, garnet, red, brick or even brownish?"
                            )
                            image("https://drive.google.com/uc?export=view&id=1DD9Za-9ePwr2V3Mxj4kfb5gACJcWVNnH")
                            buttons("Maroon", "Purple", "Ruby", "Garnet", "Red", "Brick", "Brownish")
                        }
                    }

                    state("CatchAll") {
                        activators {
                            catchAll()
                        }
                        action{
                            reactions.run {
                                go("../../Look_2")
                            }
                        }
                    }
                }

                state("Look_2", modal = true) {

                    action {
                        reactions.actions?.run {
                            addSimpleResponse(
                                "Is the wine watery or dark, translucent or opaque, dull or brilliant, cloudy or clear?",
                                "An older red wine will often have more orange tinges on the edges of color than younger red wines. Move on to the wine's opacity. Is the wine watery or dark, translucent or opaque, dull or brilliant, cloudy or clear? Can you see sediment? Tilt your glass a bit, give it a little swirl—look again, is there sediment, bits of cork or any other floaters?"
                            )
                            image("https://drive.google.com/uc?export=view&id=1PcC_-tsqrqyVaBN1BMgk-WLtL_TPZUf9")
                            buttons("Watery", "Dark", "Translucent", "Opaque", "Dull", "Brilliant", "Cloudy", "Clear")
                        }
                    }

                    state("CatchAll") {
                        activators {
                            catchAll()
                        }
                        action{
                            reactions.run {
                                go("../../Smell")
                            }
                        }
                    }

                }

                state("Smell", modal = true) {

                    action {
                        reactions.actions?.run {
                            addSimpleResponse(
                                "Swirl your glass for a solid 10 to 12 seconds and then take a quick whiff to gain a first impression.",
                                "Our sense of smell is critical in properly analyzing a glass of wine. To get a good impression of your wine's aroma, swirl your glass for a solid 10 to 12 seconds (this helps vaporize some of the wine's alcohol and release more of its natural aromas) and then take a quick whiff to gain a first impression."
                            )
                            image("https://drive.google.com/uc?export=view&id=1E-yZFUS0Q1ssiqzSbNURUWd2q_oNnxNp")
                            buttons("Next")
                        }
                    }

                    state("CatchAll") {
                        activators {
                            catchAll()
                        }
                        action{
                            reactions.run {
                                go("../../Smell_2")
                            }
                        }
                    }

                }

                state("Smell_2", modal = true) {

                    action {
                        reactions.actions?.run {
                            addSimpleResponse("Now stick your nose down into the glass and take a deep inhale through your nose. What are your second impressions?","Now stick your nose down into the glass and take a deep inhale through your nose. What are your second impressions? Do you smell oak, berry, flowers, vanilla or citrus? A wine's aroma is an excellent indicator of its quality and unique characteristics. Swirl the wine and let the aromas mix and mingle, and sniff again.")
                            image("https://drive.google.com/uc?export=view&id=1Gp7x69BxP8mon_ZtquAcS2f-DZ1sJRhm")
                            buttons("Next")
                        }
                    }

                    state("CatchAll") {
                        activators {
                            catchAll()
                        }
                        action{
                            reactions.run {
                                go("../../Taste")
                            }
                        }
                    }

                }

                state("Taste", modal = true) {

                    action {
                        reactions.actions?.run {
                            say("Finally, take a taste. Start with a small sip and let it roll around your mouth. There are three stages of taste. The Attack Phase is the initial impression that the wine makes on your palate. The Attack is comprised of four pieces of the wine puzzle: alcohol content, tannin levels, acidity, and residual sugar. These four puzzle pieces display initial sensations on the palate. Ideally, these components will be well-balanced.")
                            image("https://drive.google.com/uc?export=view&id=11pBUQRR0KYdzPQAoQO8vIA89ntIxDalp")
                            buttons("Next")
                        }
                    }

                    state("CatchAll") {
                        activators {
                            catchAll()
                        }
                        action{
                            reactions.run {
                                go("../../Taste_2")
                            }
                        }
                    }

                }

                state("Taste_2", modal = true) {

                    action {
                        reactions.actions?.run {
                            say("The Evolution Phase is also called the mid-palate or middle range phase, this is the wine’s actual taste on the palate. In this phase, you are looking to discern the flavor profile of the wine. You may start noting fruit—berry, plum, prune or fig; perhaps some spice—pepper, clove, cinnamon, or maybe a woody flavor like oak, cedar, or a detectable smokiness.")
                            image("https://drive.google.com/uc?export=view&id=16wLMFsXtHejH8lm5QZx3OtaBFoHKSYh8")
                            buttons("Next")
                        }
                    }

                    state("CatchAll") {
                        activators {
                            catchAll()
                        }
                        action{
                            reactions.run {
                                go("../../Taste_3")
                            }
                        }
                    }

                }

                state("Taste_3", modal = true) {

                    action {
                        reactions.actions?.run {
                            say("The wine's finish is how long the flavor impression lasts after it is swallowed. This is where the wine culminates, where the aftertaste comes into play. Did it last several seconds? Was it light-bodied (like the weight of water), medium-bodied (similar in weight to milk) or full-bodied (like the consistency of cream)? Can you taste the remnant of the wine on the back of your mouth and throat? Do you want another sip or was the wine too bitter at the end? What was your last flavor impression—fruit, butter, oak? Does the taste persist or is it short-lived?")
                            image("https://drive.google.com/uc?export=view&id=17Oz7FCeUlz4U36VMCx_d8NW3yunrfNq6")
                            buttons("Next")
                        }
                    }

                    state("CatchAll") {
                        activators {
                            catchAll()
                        }
                        action{
                            reactions.run {
                                go("../../Finish")
                            }
                        }
                    }

                }

                state("Finish", modal = true) {

                    action {
                        reactions.actions?.run {
                            say("After you have taken the time to taste your wine, you might record some of your impressions. Did you like the wine overall? Was it sweet, sour or bitter? How was the wine's acidity? Was it well balanced? Does it taste better with cheese, bread or a heavy meal? Will you buy it again? If so, jot the wine's name, producer and a vintage year down for future reference.")
                            image("https://drive.google.com/uc?export=view&id=12cq6uz2zbYnCsIvb8MlZsWSt4e-YHpsq")
                            buttons("Thank you!")
                        }
                    }

                    state("CatchAll") {
                        activators {
                            catchAll()
                        }
                        action{
                            reactions.actions?.run {
                                say("Bye bye!")
                                endConversation()
                            }
                        }
                    }

                }

            }

            state("WhiteWine") {
                activators {
                    intent("WhiteWine")
                }

                action {
                    reactions.run {
                        say("Ok, white wine.")
                        go("/main/RedWine")
                    }
                }
            }
        }

        fallback {
            reactions.run {
                say("Will you taste red or white wine?")
                buttons("Red", "White")
                changeState("/main")
            }
            /*reactions.actions?.run {
                say("Bye bye!")
                endConversation()
            }*/
        }

    }
}