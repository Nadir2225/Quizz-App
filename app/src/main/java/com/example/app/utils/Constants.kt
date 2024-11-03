package com.example.app.utils

import com.example.app.R
import com.example.app.module.Quetion

object Constants {
    public var score: Int = 0
    public lateinit var name: String
    public var selected: Int = 0

    public fun getQuetions(): MutableList<Quetion> {
        var quetions = mutableListOf<Quetion>()
        var quest1 = Quetion(
            "what country does this flag belong to?",
            R.drawable.spain,
            "italy",
            "algeria",
            "spain",
            "uae",
            3
        )

        quetions.add(quest1)

        var quest2 = Quetion(
            "what country does this flag belong to?",
            R.drawable.portugal,
            "portugal",
            "somalia",
            "mexico",
            "france",
            1
        )

        quetions.add(quest2)

        var quest3 = Quetion(
            "what country does this flag belong to?",
            R.drawable.morocco,
            "morocco",
            "germany",
            "belgium",
            "spain",
            1
        )

        quetions.add(quest3)

        var quest4 = Quetion(
            "what country does this flag belong to?",
            R.drawable.france,
            "austia",
            "uruguai",
            "argentina",
            "france",
            4
        )

        quetions.add(quest4)

        var quest5 = Quetion(
            "what country does this flag belong to?",
            R.drawable.canada,
            "canada",
            "tunisia",
            "croitia",
            "usa",
            1
        )

        quetions.add(quest5)

        var quest6 = Quetion(
            "what country does this flag belong to?",
            R.drawable.germany,
            "belgium",
            "germany",
            "chad",
            "russia",
            2
        )

        quetions.add(quest6)

        var quest7 = Quetion(
            "what country does this flag belong to?",
            R.drawable.japan,
            "china",
            "japan",
            "south korea",
            "india",
            2
        )

        quetions.add(quest7)

        var quest8 = Quetion(
            "what country does this flag belong to?",
            R.drawable.palastine,
            "libia",
            "iraq",
            "iran",
            "palastine",
            4
        )

        quetions.add(quest8)

        var quest9 = Quetion(
            "what country does this flag belong to?",
            R.drawable.belgium,
            "belgium",
            "netherland",
            "spain",
            "iceland",
            1
        )

        quetions.add(quest9)

        var quest10 = Quetion(
            "what country does this flag belong to?",
            R.drawable.usa,
            "greenland",
            "usa",
            "spain",
            "uae",
            2
        )

        quetions.add(quest10)

        return quetions
    }
}