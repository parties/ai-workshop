# Sample Assignment

**Use this if you didn't bring one.** It's deliberately cross-CTE — workplace safety shows up
in culinary, welding, ag, health sciences, construction, and automotive, so most people can
see their own version of it.

Copy both blocks below: the assignment, and the filled-in context. Paste them with the
[conversion prompt](conversion-prompt.md) and you're running in about thirty seconds.

---

## The assignment

```
WORKPLACE SAFETY WRITE-UP
Introduction to [Your CTE Program] — 50 points

Write a one-page paper explaining why workplace safety matters in our industry.

Your paper should:
- Explain at least three major safety hazards in this field
- Describe what can happen if safety procedures are not followed
- Explain why following safety rules is important for you and your coworkers
- Be at least 400 words
- Use complete sentences and correct spelling

Due Friday. Submit through the class portal.

RUBRIC
Three hazards identified and explained ............ 20 pts
Consequences described ............................ 15 pts
Explanation of importance ......................... 10 pts
Spelling, grammar, length ......................... 5 pts
```

## The context block, filled in

```
MY CONTEXT (I filled this in — use it, don't override it):
- Course and grade level: Introduction to CTE program, grades 9-10, mixed first-year students
- Length of a class period, and realistic work time in it: 50 minutes, about 35 minutes of
  real work time after settling and cleanup
- What my students can already do: read a procedure and follow it, identify obvious physical
  hazards when they're standing in the room, work in pairs
- What my students genuinely cannot do yet: evaluate tradeoffs between competing priorities
  like speed and safety, write an argument with a counterpoint, read a dense regulatory
  document without support
- The learning objective I actually care about here: students should be able to look at a
  real work situation and judge which hazard matters most RIGHT NOW and why — prioritizing
  under pressure, not reciting a list
- What I have to keep: the three-hazard requirement is tied to our program's safety
  certification checklist, and it has to stay
- What went wrong when students used AI on this: twenty-six of twenty-eight papers named the
  same three hazards in the same order, all of them generic to the industry rather than to
  our actual shop. Nobody mentioned the equipment we actually use. Every paper concluded
  that "safety is everyone's responsibility." I could not tell from any of them whether a
  student could spot a hazard standing in our room.
```

---

## What makes this a good test case

The gap is wide and easy to see once you're looking for it:

- A student needs to know **nothing about your shop** to produce a passing paper. The topic is generic enough that the model has all of it already.
- The objective the teacher actually cares about — **prioritizing hazards under pressure** — appears nowhere in the task or the rubric. The rubric rewards listing.
- "Explain why safety is important" has a single socially correct answer, so thirty students converge on it. That's the homogenization problem in miniature.
- Five of the fifty points are spelling and length, which AI does perfectly.

**Notice the last line of the context block.** *"I could not tell from any of them whether a
student could spot a hazard standing in our room."* That sentence is what makes the conversion
work — it names the assessment failure rather than complaining about the cheating. When you
write your own context, aim for that.

## For the "we do" block

If you're running this live with a room, the useful moves are:

- Ask for a **verb** first and take a weak one on purpose — someone will say "list" or "describe." Run it and let the output show why it wasn't enough.
- The **format** suggestion that usually cracks it open: a ranked table with a justification column. Ranking forces judgment in a way listing never does.
- Good **voice** options that change the answer completely: a new hire on day one, an insurance adjuster after an incident, a shop supervisor with a deadline.
- The **context** the room will forget: that the objective is prioritizing, not recall. Point at it when they skip it.
